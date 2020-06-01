<#macro head title>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <#nested>
</head>
</#macro>

<#macro body>
    <body>
    <#nested>
    </body>
</#macro>

