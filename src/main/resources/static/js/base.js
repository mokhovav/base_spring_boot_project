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
    /*****************************************************************************/
    const Socket = function (uil, onopen, onmessage, onerror, onclose) {
        this.uil = uil;
        this.onopen = onopen;
        this.onmessage = onmessage;
        this.onerror = onerror;
        this.onclose = onclose;
        this.socket = null;
    }

    Socket.prototype.connect = function () {
        if (this.socket != null) return false;
        this.socket = new SockJS(this.uil);
        this.socket.onopen = this.onopen;
        this.socket.onmessage = this.onmessage;
        this.socket.onerror = this.onerror;
        this.socket.onclose = this.onclose;
        return true;
    }

    Socket.prototype.disconnect = function () {
        this.socket.close();
        this.socket = null;
    }

    Socket.prototype.send = function (message) {
        if (this.socket == null) return false;
        this.socket.send(message);
        return true;
    }
    /*****************************************************************************/

    return {
        sendPostRequest,
        convertDataToObject,
        Socket
    }
}();