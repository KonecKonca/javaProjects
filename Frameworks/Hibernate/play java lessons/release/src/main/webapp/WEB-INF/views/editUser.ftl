<#import "common/common.ftl" as c>

<@c.page>
    <form name="user" action="/updateUser" method="post">
        <p>Name:</p>
        <input title="Name" type="text" name="name" value="${user.name}">
        <p>Email:</p>
        <input title="Email" type="text" name="email" value="${user.email}">
        <p>Age:</p>
        <input title="Age" type="text" name="age" value="${user.age}">

        <input type="submit" value="OK">
    </form>
</@c.page>
