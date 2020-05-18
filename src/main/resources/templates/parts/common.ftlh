<#macro pageHead title>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <#nested>
</head>
</#macro>

<#macro pageBody>
    <body>
    <#nested>
    </body>
</#macro>

