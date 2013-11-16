<!DOCTYPE html>
<html lang="en">
    <head>
        <%@page import="java.util.ArrayList"%>
        <%@page import="java.util.List"%>
        <%@page import="com.kmitsystem.tools.errorhandling.Error"%> 

        <%
            List<Error> errors = (ArrayList<Error>) request.getSession().getAttribute("errors");
            if (errors == null) {
                errors = new ArrayList<Error>();
            }
        %>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Teams Page">
        <meta name="author" content="Malte Dammann">

        <title>Teams - KmS</title>

        <!-- Bootstrap core CSS -->
        <link href="../public/css/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="../public/css/css/modern-business.css" rel="stylesheet">
        <link href="../public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    </head>

    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- You'll want to use a responsive image option so this logo looks good on devices - I recommend using something like retina.js (do a quick Google search for it and you'll find it) -->
                    <a class="navbar-brand" href="../">KmS</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="../teams">Teams</a></li>
                        <li><a href="../tournaments">Turniere</a></li> 
                        <li><a href="../statistics">Statistiken</a></li> 
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li role="presentation" class="dropdown-header">For your Interest</li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="../about">About</a></li>
                                <li><a href="../faq">FAQ</a></li>
                                <li><a href="../contact">Kontakt</a></li>
                                <li><a href="../service">Info</a></li>
                                <li><a href="../sidebar">Sidebar Page</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">User <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="../user/profil">Profil</a></li> 
                                <li><a href="../user/dashboard">Dashboard</a></li> 
                                <li><a href="../">Logout</a></li> 
                            </ul>
                        </li>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container -->
        </nav>

        <!-- Page Content -->

        <div class="container">

            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">Teams <small>Suche spezielle Turniere oder deine Freunde!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="../">Home</a></li>
                        <li class="active">Teams</li>
                    </ol>
                </div>

                <div class="row col-lg-offset-10 col-md-offset-10 col-sm-offset-10">

                    <a class="btn btn-success" href="../teams/create"><span class="fa fa-pencil"> Team erstellen <i class="fa fa-angle-right"></i></a>

                </div><!-- .row -->

                <div class="row">  
                    <div class="col-lg-12">
                        <h2 class="page-header">Teamsuche</h2>
                        <div class="row well">

                            <form class="form-horizontal" role="form">

                                <div class="col-lg-4 col-lg-offset-1">

                                    <div class="form-group">
                                        <label for="inputTeamname" class="col-sm-2 control-label">Team</label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" name="team_name_search" placeholder="Name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputTurniername" class="col-sm-2 control-label">Turnier</label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" name="turnier_name_search" placeholder="Name">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-lg-offset-1">
                                        <div class="form-group">
                                            <label for="inputUsername" class="col-sm-2 control-label">User</label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" name="user_name_search" placeholder="Name">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="inputDate" class="col-sm-3 control-label">Gr&uuml;ndungsdatum</label>
                                            <div class="col-lg-6  col-offset-2">
                                                <input type="date" name="date">
                                            </div>
                                        </div>
                                    <p class="help-block">Suche nach Teamnamen, speziell nach Teams die in bestimmtet Turnieren oder in den bestimmte User spielen.</p>
                                    
                                    <div class="form-group">
                                        <div class="col-md-offset-8">
                                            <button type="submit" class="btn btn-primary"><span class="fa fa-search"> Suche <i class="fa fa-angle-right"></i></button>
                                        </div>
                                    </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div> <!-- row --> 

            <hr>  

            <div class="row">

                <div class="col-md-7">
                    <a href="teams/profil"><img class="img-responsive" src="http://placehold.it/750x350"></a>
                </div>

                <div class="col-md-5">
                    <h3>Team Name</h3>
                    <h4>Subheading</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae. Sed dui lorem, adipiscing in adipiscing et, interdum nec metus. Mauris ultricies, justo eu convallis placerat, felis enim.</p>
                    <a class="btn btn-success" href="../tournaments/profil">Zum Team <i class="fa fa-angle-right"></i></a>
                </div>

            </div>

            <hr>

            <div class="row">

                <div class="col-md-7">
                    <a href="../tournaments/profil"><img class="img-responsive" src="http://placehold.it/750x350"></a>
                </div>

                <div class="col-md-5">
                    <h3>Team Name</h3>
                    <h4>Subheading</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae. Sed dui lorem, adipiscing in adipiscing et, interdum nec metus. Mauris ultricies, justo eu convallis placerat, felis enim.</p>
                    <a class="btn btn-success" href="../tournaments/profil">Zum Team <i class="fa fa-angle-right"></i></a>
                </div>

            </div>

            <hr>

            <div class="row text-center">

                <div class="col-lg-12">
                    <ul class="pagination">
                        <li><a href="#">&laquo;</a></li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&raquo;</a></li>
                    </ul>        
                </div>

            </div>

            <div class="container">

                <hr>

                <footer>
                    <div class="row">
                        <div class="col-lg-12">
                            <p>Copyright &copy; KmS 2013</p>
                        </div>
                    </div>
                </footer>

            </div><!-- /.container -->

            <!-- Bootstrap core JavaScript -->
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="../public/js/jquery.js"></script>
            <script src="../public/js/bootstrap.js"></script>
            <script src="../public/js/modern-business.js"></script>

    </body>
</html>
