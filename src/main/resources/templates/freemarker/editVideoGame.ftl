<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${title}</title>

    <link href="../../bootstrap-4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../bootstrap-4.3.1/style/creation-form.css" rel="stylesheet">

</head>
<body class="bg-light">
<div class="container">
    <div class="py-5 text-center">
        <h1>Edit Videogame</h1>
    </div>


    <div class="center-container">


        <div class="row">

            <div class="col-md-8 order-md-1">
                <h4 class="mb-3">Write the information of the videogame</h4>

                <form method="post" action="/videogames/edit/?id=${videogame.id}" class="needs-validation" enctype="multipart/form-data" novalidate >
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="name">Videogame name</label>
                            <input type="text" class="form-control" value="${videogame.name}" id="name" name="name" placeholder="Videogame name"  required>

                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="developer">Developer</label>
                            <select class="custom-select d-block w-100" id="developer" name="developer" required>
                                <option value="${videogame.developer}">${videogame.developer}</option>
                                <option value="Sony">Sony</option>
                                <option value="Microsoft">Microsoft</option>
                                <option value="Nintendo">Nintendo</option>
                                <option value="Sega">Sega</option>
                                <option value="Santa Monica Studios">Santa Monica Studios</option>
                                <option value="Square Enix">Square Enix</option>
                                <option value="Bandai Namco">Bandai Namco</option>
                                <option value="Konami">Konami</option>
                                <option value="Capcom">Capcom</option>
                                <option value="Atlus">Atlus</option>
                            </select>

                        </div>
                    </div>


                    <div class="mb-3">
                        <label for="genre">Genre</label>
                        <select class="custom-select d-block w-100" id="genre" name="genre" required>
                            <option value="${videogame.genre}">${videogame.genre}</option>
                            <option value="Action">Action</option>
                            <option value="First-person shooter">First-person shooter</option>
                            <option value="Third-person shooter">Third-person shooter</option>
                            <option value="RPG">RPG</option>
                            <option value="JRPG">JRPG</option>
                            <option value="2D Fighting">2D Fighting</option>
                            <option value="3D Fighting">3D Fighting</option>
                            <option value="Survival horror">Survival horror</option>
                        </select>

                    </div>


                    <div class="mb-3">
                        <label for="gameModes">Game modes</label>
                        <select class="custom-select d-block w-100" id="gameModes" name="gameModes" required>
                            <option value="${videogame.gameModes}">${videogame.gameModes}</option>
                            <option value="Single-player">Single-player</option>
                            <option value="Multiplayer">Multiplayer</option>
                            <option value="Single-player, Multiplayer">Single-player, Multiplayer</option>
                        </select>

                    </div>


                    <div class="mb-3">
                        <label for="releasedDate">Released date</label>
                        <div class="input-group">
                            <input type="date" class="form-control" id="releasedDate" name="releasedDate" placeholder="Leave empty if does not want to change it">

                        </div>
                    </div>


                    <div class="mb-3">
                        <label for="unitsSold">Units sold</label>
                        <div class="input-group">
                            <input type="number" class="form-control" id="unitsSold" name="unitsSold" placeholder="Leave empty if does not want to change it" >

                        </div>
                    </div>


                    <div class="mb-3">
                        <label for="sellPrice">Selling price</label>
                        <div class="input-group">
                            <input type="number"  class="form-control" id="sellPrice" name="sellPrice" placeholder="Leave empty if does not want to change it" >

                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="rating">Rating of the game</label>
                        <select class="custom-select d-block w-100" id="rating" name="rating" required>
                            <option value="${videogame.rating}">${videogame.rating}</option>
                            <option value="1.0">1.0</option>
                            <option value="2.0">2.0</option>
                            <option value="3.0">3.0</option>
                            <option value="4.0">4.0</option>
                            <option value="5.0">5.0</option>
                            <option value="6.0">6.0</option>
                            <option value="7.0">7.0</option>
                            <option value="8.0">8.0</option>
                            <option value="9.0">9.0</option>
                            <option value="10">10</option>
                        </select>

                    </div>

                    <div class="mb-3">
                        <label for="stock">Stock</label>
                        <div class="input-group">
                            <input type="number" value="${videogame.stock}" class="form-control" id="stock" name="stock" placeholder="Stock" required>

                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="idConsoles">Platforms of the game</label>

                        <div class="input-group">
                            <select multiple class="form-control" name="idConsoles" required>
                                <#list consoles as console>
                                    <option value="${console.id}" >${console.name} - ${console.developer} - ${console.consoleType} - ${console.generation}th generation</option>
                                </#list>
                            </select>
                        </div>

                    <div class="mb-3">
                        <label for="image">Picture of the cover</label>
                        <div class="input-group">
                            <input type="file" class="form-control" value="${videogame.image}" id="image" name="image" placeholder="Picture of the cover">

                        </div>
                    </div>

                    <hr class="mb-4">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Save videogame</button>
                    <hr class="mb-4">
                    <a class="btn btn-danger btn-lg btn-block" href="/videogames/admin" role="button">Cancel</a>
                </form>
            </div>
        </div>
    </div>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2019 Arkham-Store</p>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
    </footer>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script>window.jQuery || document.write('<script src="../../bootstrap-4.3.1/dist/js/jquery-3.2.1.slim.min.js"><\/script>')</script><script src="../../bootstrap-4.3.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="../../bootstrap-4.3.1/dist/js/form-validation.js"></script></body>
</html>
