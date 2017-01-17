<h1>User</h1>

Welcome
<sec:ifLoggedIn>
    <sec:ifAnyGranted roles="ROLE_ADMIN">
        Admin!
    </sec:ifAnyGranted>
    <sec:ifAnyGranted roles="ROLE_CUSTOMER">
        Customer!
    </sec:ifAnyGranted>
    <sec:ifNotGranted roles="ROLE_ADMIN">
        *
    </sec:ifNotGranted>
    <h2 style="color: red">${user?.username}</h2>

    <h2 style="color: magenta">${user?.authorities}</h2>

</sec:ifLoggedIn>
<sec:ifNotLoggedIn>
    <g:link controller='login' action='auth'>Login</g:link>
</sec:ifNotLoggedIn>

<g:link controller='logout'>Logout</g:link>