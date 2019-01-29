<#import "common/common.ftl" as c>

<@c.page>
<h1>I am first template</h1>
    <h2> User info </h2>
    <table>
        <tr>
            <td>Id</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td>Age</td>
            <td>${user.age}</td>
        </tr>
        <tr>
            <td>Access</td>
            <td>${user.access}</td>
        </tr>
    </table>

    <a href="/users"> Back </a>

</@c.page>