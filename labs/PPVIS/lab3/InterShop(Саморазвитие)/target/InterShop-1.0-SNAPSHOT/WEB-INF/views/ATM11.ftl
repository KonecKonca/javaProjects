<#import "common/common.ftl" as c>

<@c.page>

    <h3>+375</h3>
    <form name="sumForPay" action="/ATM11" method="post">
        <input title="nomber" type="text" name="nomber">
        <br>
        <h3>Sum: </h3>
        <input title="sumForPay" type="text" name="sumForPay">

        <input type="submit" value="Pay">
    </form>

</@c.page>