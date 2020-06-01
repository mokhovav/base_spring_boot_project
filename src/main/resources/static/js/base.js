Base = function () {
    /*****************************************************************************/
    // Functions for sending and receiving messages using the POST method
    function sendPostRequest(context, address = "/", message, func) {
        let xmlHttp;
        if (window.XMLHttpRequest) {
            // code for modern browsers
            xmlHttp = new XMLHttpRequest();
        } else {
            // code for old IE browsers
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlHttp.open("POST", address + "/" + JSON.stringify(message), true);
        let csrf_token = document.getElementById("csrf_token");
        if (csrf_token != null) xmlHttp.setRequestHeader("X-XSRF-TOKEN", csrf_token.getAttribute("value"));
        xmlHttp.send();
        xmlHttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                func(context, this.responseText);
            }
        }
    }
    /*****************************************************************************/
    /*****************************************************************************/
    function convertDataToObject (text) {
        return JSON.parse(text);
    }
    /*****************************************************************************/
    return {
        sendPostRequest,
        convertDataToObject
    }
}();