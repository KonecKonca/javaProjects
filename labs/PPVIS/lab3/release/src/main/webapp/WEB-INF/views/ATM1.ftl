<#import "common/commonWihoutNavbar.ftl" as c>

<@c.page>

    <form name="card" action="/ATM1" method="post">
        <p>Number of card</p>
        <input title="number" type="text" name="number">
        <p>password:</p>
        <input title="password" type="password" name="password">

        <input type="submit" value="OK">
    </form>

</@c.page>