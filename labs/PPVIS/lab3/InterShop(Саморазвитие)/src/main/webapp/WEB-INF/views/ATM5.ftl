<#import "common/common.ftl" as c>

<@c.page>

    <h1>Pay for anythink with ERIP system</h1>

    <form name="sumForPayErip" action="/ATM5" method="post">
        <h3>ERIP nomber: </h3>
        <input title="eripNomber" type="text" name="eripNomber">
        <br>
        <h3>Sum: </h3>
        <input title="sumForPayErip" type="text" name="sumForPayErip">

        <input type="submit" value="Pay">
    </form>
</@c.page>