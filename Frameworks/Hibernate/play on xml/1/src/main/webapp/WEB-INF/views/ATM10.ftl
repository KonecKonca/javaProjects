<#import "common/common.ftl" as c>

<@c.page>

    <h1>There are all comments about our bank:<br></h1>

    <#list comments as comment>
        <li><strong><h2>${comment}</h2></strong><br></li>
    </#list>

</@c.page>