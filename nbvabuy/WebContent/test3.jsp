<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-au">
<head>
<meta charset="utf-8" />
<title>Form from AJAX using jQuery</title>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

<script>

// NB: the JavaScript stuff here is all client side and is the AJAX client

// encapsulate the lot within a function scope called on document ready
jQuery(function($) {

    // hook the submit action on the form
    $("#form-ajax").submit(function(event) {
        // stop the form submitting
        event.preventDefault();

        // grab the ID and send AJAX request if not (empty / only whitespace)
        var ID = this.elements.ID.value;
        if (/\S/.test(ID)) {

            // using the ajax() method directly
            $.ajax({
                type : "GET",
                url : url,
                cache : false,
                dataType : "json",
                data : data,
                success : process_response,
                error: function(xhr) { alert("AJAX request failed: " + xhr.status); }
            });

            // there is a shortcut method to GET JSON:
            // $.getJSON(url, data, process_response);
        }
        else {
            alert("No ID supplied");
        }
    };

    /**
    * process the response, populating the form fields from the JSON data
    * @param {Object} response the JSON data parsed into an object
    */
    function process_response(response) {
        var frm = $("#form-ajax");
        var i;

        console.dir(response);      // for debug

        for (i in response) {
            frm.find('[name="' + i + '"]').val(response[i]);
        }
    }

});

</script>

</head>

<body>

    <form id="form-ajax" action="fetch.jsp">
        <label>ID:</label><input type="text" name="ID" /><br/> <BR>
         
        <input type="submit" value="Submit" /> <BR>
    </form>
    
    
    <BR>
    
    <form id="form1" name="form1" method="post">
<div class="form-group">
<input type="text" class="form-control" placeholder= 'Search by rollno...' id="roll_no"><br>
<p align="center"><button type="submit" class="btn btn-primary btn-default" id="search">Submit</button></p><br>
<label for="city">Display city name of student:</label>
<input type="email" class="form-control" placeholder= 'City name' id="city_name"><br><br>
</div>
</form>

</body>

</html>