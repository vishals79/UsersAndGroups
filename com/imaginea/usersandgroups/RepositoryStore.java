package com.imaginea.usersandgroups;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class RepositoryStore {
	private static Map<String, User> usersMap = new ConcurrentHashMap<>();
	private static Map<String, Group> groupMap = new ConcurrentHashMap<>();
	public RepositoryStore() {
		super();
	}

	

	public void addUser(final User user) {
		usersMap.put(user.uniqueIdentifier(), user);
	}

	public void removeUser(final String userId) {

		if (usersMap.containsKey(userId)) {
			for (Group group : groupMap.values()) {
				List<String> usersList = group.service.usersInTheUsersList();
				for (String user : usersList) {
					if (user.equals(usersMap.get(userId).getUser()))
						group.service.removeUserFromGroup(usersMap.get(userId));
				}
			}
			usersMap.remove(userId);
		}

	}

	public void addGroup(final Group group) {
		groupMap.put(group.uniqueIdentifier(), group);
	}

	public void removeGroup(final String gId) {
		if (groupMap.containsKey(gId)) {
			for (Group group : groupMap.values()) {
				List<String> groupsList = group.service.groupsInTheGroupsList();
				for (String groupName : groupsList) {
					if (groupName.equals(groupMap.get(gId).getGroup()))
						group.service.removeGroupFromGroup(groupMap.get(gId));
				}
			}
			groupMap.remove(gId);
		}
	}

	public User retriveUser(String id) {
		for (User user : usersMap.values()) {
			if (user.uniqueIdentifier().contentEquals(id))
				return user;

		}
		return null;
	}

	public void retriveUsers() {
		List<User> usersList = new ArrayList<>();
		for (User user : usersMap.values())
			usersList.add(user);
		for (User user : usersList)
			System.out.println(user);

	}

	public Group retriveGroup(String id) {
		for (Group group : groupMap.values()) {
			if (group.uniqueIdentifier().contentEquals(id))
				return group;

		}
		return null;

	}

	public void retriveGroups() {
		List<Group> groupList = new ArrayList<>();
		for (Group group : groupMap.values())
			groupList.add(group);
		for (Group group : groupList) {
			if (group == null)
				throw new RuntimeException("group not exist");

			else {
				System.out.println(group);
				List<String> usersList = new ArrayList<>();
				List<String> groupsList = new ArrayList<>();
				usersList = group.service.usersInTheUsersList();
				groupsList = group.service.groupsInTheGroupsList();
				System.out.println("users of this group are");
				for (String user : usersList) {
					System.out.println(user);
				}
				System.out.println("groups of this group are");
				for (String groupName : groupsList) {
					System.out.println(groupName);
				}
			}

		}

	}
	public int getNoOfUsers()
	{
		return usersMap.size();
	}
	public int getNoOfGroups()
	{
		return groupMap.size();
	}
}
