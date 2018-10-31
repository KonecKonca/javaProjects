<#import "common/common.ftl" as c>

<@c.page>
<h1>I am first template</h1>
    <h2> User info </h2>
    <table>
        <tr>
            <td>Name</td>
            <td>${product.name}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${product.category}</td>
        </tr>
        <tr>
            <td>Age</td>
            <td>${product.price}</td>
        </tr>
        <tr>
            <td>Access</td>
            <td>${product.rate}</td>
        </tr>
        <tr>
            <td>Access</td>
            <td>${product.description}</td>
        </tr>
    </table>

    <a href="/"> To Home </a>

</@c.page>
