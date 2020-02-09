<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="styles.css">

    <title>LMS by Eduards</title>
</head>

<body>
<!-- Navbar -->
<section>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/admin-user">LMS by Eduards</a>
        <div class="lms-user-type">|</div>
        <div class="lms-user-type">Admin</div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="lms-nav-item nav-item">
                    <a class="nav-link" href="/stats">Create new lottery</a>
                </li>
                <li class="lms-nav-item nav-item">
                    <a class="nav-link" href="/stats">Display statistics</a>
                </li>
                <li class="lms-nav-item nav-item">
                    <a class="nav-link" href="select-user">Log out</a>
                </li>
            </ul>
        </div>
    </nav>
</section>

<!-- Functions -->
<section>
    <div class="lms-button-container container-fulid lms-functional-container">
        <div class="row">
            <div class="col-md-6 text-center">
                <button type="button" class="btn btn-primary btn-lg lms-functional-button">Create new lottery</button>
            </div>
            <div class="col-md-6 text-center">
                <button type="button" class="btn btn-primary btn-lg lms-functional-button">Display statistics</button>
            </div>
        </div>
    </div>
</section>

<!-- Lotteries -->
<section>
    <div class="container-fluid">
        <div class="row">
            <c:forEach items="${lotteries}" var="lottery">
            <div class="text-center">
                <div class="lms-lottery-field">
                    <h1>ID: ${lottery.id}</h1>
                    <h1>Name: ${lottery.name}</h1>
                    <h2>Number of participants: ${lottery.numberOfParticipants}</h2>
                    <button type="button" class="btn btn-primary lms-lottery-button">View lottery</button>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</section>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>

</html>


<script
        src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
        crossorigin="anonymous"></script>