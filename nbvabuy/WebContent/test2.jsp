 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#save').click(function ()
        {
            $.ajax({
                type: "post",
                url: "test2sub.jsp", //this is my servlet
                data: {
                    input: $('#id').val(), 
                    output: $('#op').val()
                },
                success: function(msg){      
                        $('#output').append(msg);
                }
            });
        });

    });
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
    input:<input id="id" type="text" name="" value="" /><br></br>
    output:<input id="op" type="text" name="" value="" /><br></br>
    <input type="button" value="save" name="save" id="save"/>
   <div id="output"></div>
</body>