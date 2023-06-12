<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
        <title>Happy Programming</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .main-content {
            padding: 50px 0;
        }

        .text-center {
            text-align: center;
        }

        .text-uppercase {
            text-transform: uppercase;
        }

        .text-muted {
            color: #777;
        }

        .stat-card {
            background-color: #f7f7f7;
            padding: 20px;
            text-align: center;
            margin-bottom: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .stat-card__content p {
            margin-bottom: 5px;
        }

        .stat-card__content h2 {
            margin-bottom: 0;
            font-size: 32px;
        }

        .stat-card__content span {
            font-size: 14px;
        }

        .text-danger {
            color: #dc3545;
        }

        .text-success {
            color: #28a745;
        }

        .offset-1 {
            margin-left: 8.33333333%;
        }

        hr {
            margin-top: 40px;
            margin-bottom: 40px;
            border: 0;
            border-top: 1px solid #dee2e6;
        }

        @media (max-width: 576px) {
            .offset-1 {
                margin-left: 0;
            }
        }
    </style>
</head>
<body>
    <section class="main-content">
        <div class="container">
            <h1 class="text-center text-uppercase">Statistic Requirement</h1>

            <div class="row">
                <div class="col-sm-4 offset-4">
                    <div class="stat-card">
                        <div class="stat-card__content">
                            <p class="text-uppercase mb-1 text-muted">Number of Requests</p>
                            <h2>${total}</h2>
                        </div>
                    </div>
                </div>
                <div class="col-sm-10 offset-1">
                    <hr>
                </div>
                <div class="col-sm-2 offset-1">
                    <div class="stat-card">
                        <div class="stat-card__content">
                            <p class="text-uppercase mb-1 text-muted">Open</p>
                            <h2>${open}</h2>
                            <div>
                                <span class="text-danger font-weight-bold mr-1">${open / total * 100}%</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-2 offset-1">
                    <div class="stat-card">
                        <div class="stat-card__content">
                            <p class="text-uppercase mb-1 text-muted">Processing</p>
                            <h2>${processing}</h2>
                            <div>
                                <span class="font-weight-bold mr-1">${processing / total * 100}%</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-2 offset-1">
                    <div class="stat-card">
                        <div class="stat-card__content">
                            <p class="text-uppercase mb-1 text-muted">Accepted</p>
                            <h2>${accepted}</h2>
                            <div>
                                <span class="text-success font-weight-bold mr-1">${accepted / total * 100}%</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-2 offset-1">
                    <div class="stat-card">
                        <div class="stat-card__content">
                            <p class="text-uppercase mb-1 text-muted">Rejected</p>
                            <h2>${rejected}</h2>
                            <div>
                                <span class="text-danger font-weight-bold mr-1">${rejected / total * 100}%</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-2 offset-1"></div>
                <div class="col-sm-2 offset-1"></div>
                <div class="col-sm-2 offset-1"></div>
                <div class="col-sm-2 offset-1">
                    <div class="stat-card">
                        <div class="stat-card__content">
                            <h2>${rate}/5.0 star</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
