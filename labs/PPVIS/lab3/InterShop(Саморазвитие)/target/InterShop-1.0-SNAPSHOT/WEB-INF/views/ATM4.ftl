<#import "common/common.ftl" as c>

<@c.page>

    <h1>Add comment lower <br></h1>

        <form name="comment" action="/ATM4" method="post">
            <h3>Your comment: </h3>
            <input title="Name" type="text" name="comment">

            <input type="submit" value="Add">
        </form>

</@c.page>