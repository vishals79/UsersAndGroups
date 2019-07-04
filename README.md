# UsersAndGroups

This README file explains how to work with this project.
In this project we can create a user and can create a group.We can add some users to the groups.Similarly we can add groups to the groups.
We can Remove user and can Remove group permenantly.In this case it first checks for whether it is belongs to any group,if so it first deletes from the group and then deletes from the Repository.
We can Remove a user and a group from the group it belongs to.

*Application class->
Project starts with the Application class which contains main method in which it asks for choosing an option.
options are like 1.create user,2.create group etc.
The methods that are responding to these options are including in this class.

*User class->
Includes creating a userInstance.
include getting unique identifier.Here I considered unique Identifier as userId.

*group Class->
Includes creating a GroupInstance.
getting unique identifier same like user.

*Repository Class->
Includes methods to store and retrive the values of users and groups using Map.

*UsersList class->
Getting users belongs to the particular group includes in this.

*GroupsList
Getting groups belongs to the particular group includes in this class.

*updated
