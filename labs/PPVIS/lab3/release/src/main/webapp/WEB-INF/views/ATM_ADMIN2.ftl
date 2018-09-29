<#import "common/commonWihoutNavbar.ftl" as c>

<@c.page>


    <h1>There are all comments about our bank:<br></h1>

    <#list comments as comment>
        <li><strong><h1><a href="/ATM_ADMIN3/${comment}">DELETE</a> </h1><h2>${comment}</h2></strong><br></li>
    </#list>

</@c.page>