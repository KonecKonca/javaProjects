<#import "common/common.ftl" as c>

<@c.page>

        <form name="byer" action="/addUser" method="post">
            <p>Name:</p>
            <input title="Name" type="text" name="name">
            <p>Email:</p>
            <input title="Email" type="text" name="email">
            <p>Age:</p>
            <input title="Age" type="text" name="age">

            <input type="submit" value="OK">
        </form>
</@c.page>
