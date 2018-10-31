<#import "common/common.ftl" as c>

<@c.page>

    <h1> Choose the necessary sum: <br></h1>

    <table id="getMoney">
        <tr>
            <th>
                <form name="inputSum" action="/ATM7_1" method="post">
                    <button>
                        <h1>
                            <font color="red">10</font>
                        </h1>
                    </button>
                </form>
            </th>
            <th>
                <form name="inputSum" action="/ATM7_2" method="post">
                    <button>
                        <h1>
                            <font color="red">50</font>
                        </h1>
                    </button>
                </form>
            </th>
        </tr>
        <tr>
            <th>
                <form name="inputSum" action="/ATM7_3" method="post">
                    <button>
                        <h1>
                            <font color="red">20</font>
                        </h1>
                    </button>
                </form>
            </th>
            <th>
                <form name="inputSum" action="/ATM7_4" method="post">
                    <button>
                        <h1>
                            <font color="red">100</font>
                        </h1>
                    </button>
                </form>
            </th>
        </tr>
    </table>

    <h3>Input another sum (must divide on <font color="red">10</font>) <br></h3>

        <form name="inputSum" action="/ATM7" method="post">
            <input title="inputSum" type="text" name="inputSum">

            <input type="submit" value="get">
        </form>



</@c.page>