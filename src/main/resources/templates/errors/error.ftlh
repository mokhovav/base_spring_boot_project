<#import "../parts/common.ftlh" as common>

<@common.head title="Error"></@common.head>

<@common.body >
    <div>Something went wrong</div>
    <div>We are already working on this issue</div>
    <div>Error: <#if error??>${error}</#if></div>
</@common.body>


