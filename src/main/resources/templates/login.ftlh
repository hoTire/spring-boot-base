<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring Security Login</title>
</head>
<body>
    <#if RequestParameters.logout??>
        <div>
            You have been logged out.
        </div>
    </#if>
    <#if RequestParameters.error??>
        <div>
            Invalid username and password.
        </div>
    </#if>
    <br/>
    <form action="/login" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Sign In"/></div>
    </form>
</body>
</html>