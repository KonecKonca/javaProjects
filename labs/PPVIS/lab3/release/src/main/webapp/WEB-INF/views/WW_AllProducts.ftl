<#import "common/common.ftl" as c>

<@c.page>
    <h5> List of all products </h5>

        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th>Rate</th>
                <th>Description</th>
            </tr>
        <#list products as product>
            <tr>
                <td><a href="/product/${product.product_id}">${product.product_id}</a></td>
                <td>${product.name}</td>
                <td>${product.category}</td>
                <td>${product.price}</td>
                <td>${product.rate}</td>
                <td>${product.description}</td>
            </tr>
        </#list>
        </table>

</@c.page>
