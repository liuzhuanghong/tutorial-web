<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Steven</title>

<!-- Bootstrap -->
<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>Product</h1>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">Product List</div>
			<div class="panel-body">
				<div id="product"></div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!-- <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script> -->
	<script src="js/3rd/jquery/jquery-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/3rd/bootstrap/bootstrap.js"></script>
	<script
		src="http://cdn.bootcss.com/handlebars.js/1.3.0/handlebars.min.js"></script>

	<script type="text/x-handlebars-template" id="product_table_template">
    {{#if data}}
        <table class="table table-hover" id="product_table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                {{#data}}
                    <tr data-id="{{id}}" data-name="{{name}}">
                        <td>{{id}}</td>
                        <td>{{name}}</td>
                        <td>{{price}}</td>
                    </tr>
                {{/data}}
            </tbody>
        </table>
    {{else}}
        <div class="alert alert-warning">Can not find any data!</div>
    {{/if}}
    </script>


	<script>
		$(function() {
			$
					.ajax({
						type : 'get',
						url : 'http://localhost:8088/tutorial-web/ws/productService/',
						dataType : 'json',
						success : function(data) {
							var template = $("#product_table_template").html();
							var render = Handlebars.compile(template);
							var html = render({
								data : data
							});
							$('#product').html(html);
						}
					});
		});
	</script>

</body>
</html>
