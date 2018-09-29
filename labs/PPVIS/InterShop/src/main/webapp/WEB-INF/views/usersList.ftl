<#import "common/common.ftl" as c>

<@c.page>

    <h1>  Users List  </h1>
    <table>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>EMAIL</th>
            <th>AGE</th>
            <th>ACCESS</th>
        </tr>
        <#list users as user>
            <tr>
                <td><a href="/user/${user.id}">${user.id}</a></td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.age}</td>
                <td>${user.access}</td>
                <td><a href="/delete/${user.id}">Delete</a> </td>
                <td><a href="/update/${user.id}">Update</a> </td>
            </tr>
        </#list>
    </table>

    <a href="/addUser">Create User</a>
</@c.page>
