<#import "common/common.ftl" as c>

<@c.page>

    <h1>You have : <font color="red">${card.money}</font></h1><br>

<form  action="/ATM7" method="get">
    <button>
        <h1>
            Get money
        </h1>
    </button>
</form>

</@c.page>