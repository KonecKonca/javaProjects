<#import "common/commonWihoutNavbar.ftl" as c>

<@c.page>

    <h1>Adminochka<br></h1>
    <h1>Enter admin attributes:<br></h1>

        <form name="adminData" action="/admin" method="post">
            <p>Login</p>
            <input title="adminName" type="text" name="adminName">

            <p>Password:</p>
            <input title="password" type="password" name="password">

            <input type="submit" value="OK">
        </form>

</@c.page>