<%@ page import="net.golovach.eshop.entity.MockEntityB" %>
html>
    <body>
        <b>MNC Mock View</b>
        <br/>requestAttribute.str = ${requestAttribute.str}
        <br/>requestAttribute.map['key-0'] = ${requestAttribute.map['key-0']}
        <br/>requestAttribute.mockEntityB.str = ${requestAttribute.mockEntityB.str}
        <br/>sessionAttribute.array[1] = ${sessionAttribute.array[1]}
        <br/>servletContextAttribute.list[0] = ${servletContextAttribute.list[0]}
        <hr/>
        <jsp:useBean id="pageBean" scope="page" class="net.golovach.eshop.entity.MockEntityB"/>
        <br/>pageBean.str = ${pageBean.str}
        <hr/>
        <br/>(pageBean.intValue0 gt -10) and (pageBean.intValue1 lt -10) =
             ${(pageBean.intValue0 gt -10) and (pageBean.intValue1 lt -10)}
        <hr/>
        <br/>test = ${test}
    </body>
</html>