<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Current Tariffs</title>
</head>
<body>

    <div>

        <h2>Tariffs</h2>
        <br>

        <h3>Unlimit Tarifs</h3>
        <table>
            <tr>
                <td>Name</td>
                <td>Operator</td>
                <td>SMS</td>
                <td>Tariffication</td>
                <td>Connection</td>
                <td>Favourite number</td>
                <td>Internal call</td>
                <td>External call</td>
                <td>MB price</td>
            </tr>

            <c:forEach var="element" items="${unlimitList}">
                <tr>
                    <td>########</td>
                    <td>########</td>
                    <td>########</td>
                    <td>########</td>
                    <td>########</td>

                    <td>########</td>
                    <td>########</td>
                    <td>########</td>
                    <td>########</td>
                    <td>########</td>
                </tr>
                <tr>
                    <td><c:out value="${element.getName()}"/></td>
                    <td><c:out value="${element.getOperatorName()}"/></td>
                    <td><c:out value="${element.getSmsPrice()}"/></td>

                    <td><c:out value="${element.getTariffParameters().getTarifficationType()}"/></td>
                    <td><c:out value="${element.getTariffParameters().getPayForConnection()}"/></td>
                    <td><c:out value="${element.getTariffParameters().getFavouriteNumber()}"/></td>

                    <td><c:out value="${element.isHasInternalCall() }"/></td>
                    <td><c:out value="${element.isHasExternalCall()}"/></td>
                    <td><c:out value="${element.isHasInternet()}"/></td>
                    <td><c:out value="${element.getPayroll()}"/></td>
                </tr>
            </c:forEach>

        </table>
        <br><br><br>

        <h3>Limit Tarifs</h3>
        <table>
            <tr>
                <td>Name</td>
                <td>Operator</td>
                <td>SMS</td>
                <td>Tariffication</td>
                <td>Connection</td>
                <td>Favourite number</td>
                <td>Internal call</td>
                <td>External call</td>
                <td>Internet</td>
                <td>Payroll</td>
            </tr>

            <c:forEach var="element" items="${limitList}">
                <tr>
                    <td>########</td>
                    <td>########</td>
                    <td>########</td>
                    <td>########</td>
                    <td>########</td>

                    <td>########</td>
                    <td>########</td>
                    <td>########</td>
                    <td>########</td>
                    <td>########</td>
                </tr>
                <tr>
                    <td><c:out value="${element.getName()}"/></td>
                    <td><c:out value="${element.getOperatorName()}"/></td>
                    <td><c:out value="${element.getSmsPrice()}"/></td>

                    <td><c:out value="${element.getTariffParameters().getTarifficationType()}"/></td>
                    <td><c:out value="${element.getTariffParameters().getPayForConnection()}"/></td>
                    <td><c:out value="${element.getTariffParameters().getFavouriteNumber()}"/></td>

                    <td><c:out value="${element.getInternalCallPrice() }"/></td>
                    <td><c:out value="${element.getExternalCallPrice()}"/></td>
                    <td><c:out value="${element.getMbPrice()}"/></td>
                </tr>
            </c:forEach>

        </table>

    </div>

</body>
</html>
