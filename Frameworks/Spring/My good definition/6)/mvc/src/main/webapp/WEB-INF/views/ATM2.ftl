<#import "common/common.ftl" as c>

<@c.page>

    <table id="menu">
        <tr>
            <th>
                <form  action="/ATM3" method="get">
                    <button>
                        <h1>
                            Exchange Rates
                        </h1>
                    </button>
                </form>

            </th>
            <th>
                <form  action="/ATM6" method="get">
                    <button>
                        <h1>
                            Check the balance
                        </h1>
                    </button>
                </form>

            </th>
        </tr>
        <tr>
            <th>
                <form  action="/ATM11" method="get">
                    <button>
                        <h1>
                            Put money on the mobily
                        </h1>
                    </button>
                </form>

            </th>
            <th>
                <form  action="/ATM7" method="get">
                    <button>
                        <h1>
                            Get money
                        </h1>
                    </button>
                </form>

            </th>
        </tr>
        <tr>
            <th>
                <form  action="/ATM4" method="get">
                    <button>
                        <h1>
                            Add comment
                        </h1>
                    </button>
                </form>
            </th>
            <th>
                <form  action="/ATM5" method="get">
                    <button>
                        <h1>
                            ERIP Payments
                        </h1>
                    </button>
                </form>
            </th>
        </tr>
    </table>

</@c.page>