<script>
    import { onMount, beforeUpdate } from "svelte";
    import axios from "axios";
    const key = "cd0b2d6a52d63650262b52f34f31481f";

    let currentLoc ="";
    let result = [];
    let errors = [];
    async function data(...params) {
        try {
            const response = await fetch(
                `http://api.openweathermap.org/data/2.5/weather?q=${params[0]}&units=${params[1]}&appid=${key}`,
                { mode: "cors" }
            );
            if (response.ok) {
                const getData = await response.json();
                params[1] === "metric"
                    ? (getData.units = "°C")
                    : (getData.units = "°F");
                return getData;
            }
            return { error: "Please enter a valid city" };
        } catch (e) {
            return { error: e };
        }
    }

    async function callApi() {
        const input = document.getElementById("city");
        const units = document.querySelector(
            'input[name="unitRadios"]:checked'
        ).value;
        const datum = await data(input.value, units)
            .then((res) => (result = res))
            .catch((error) => {
                errors = error;
                console.log(errors);
            });
        return datum;
    }

    
    onMount(async() => {
        await axios.get('https://ipgeolocation.abstractapi.com/v1/?api_key=560c97c91b92403bb09889633c39e5e2')
    .then(res => {
       currentLoc=res.data.city; 
    })
    .catch(error => {
        console.log(error);
    });
        
    });


</script>

<main>
    <div class="card container" id="container">
        <h1>Weather</h1>
        <form class="form-inline ">
            <input type="text" id="city" value={currentLoc} />
            <button
                class="btn btn-outline-success "
                on:click|preventDefault={(e) => {
                    callApi();
                }}>Search</button
            >
            <br />

            <div class="form-check form-check-inline">
                <label class="form-check-label" for="radioC">Celsius</label>
                <input
                    class="form-check input"
                    id="radioC"
                    type="radio"
                    value="metric"
                    name="unitRadios"
                    checked
                    on:change={(e) => callApi()}
                />
            </div>
            <div class="form-check form-check-inline">
                <label class="form-check-label" for="radioF">Farenheit</label
                ><input
                    class="form-check input"
                    id="radioF"
                    type="radio"
                    value="imperial"
                    name="unitRadios"
                    on:change={(e) => callApi()}
                />
            </div>
            <br />

            {#if result.length != 0 && !result.error}
                <div class="container" id="container">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">
                                {result.name}, {result.sys.country}
                            </h5>
                            <h6 class="card-subtitle mb-2">
                                Current temperature: {result.main
                                    .temp}{result.units}
                            </h6>
                            <p class="card-text">
                                Feels Like: {result.main.feels_like}
                                {result.units}
                            </p>
                            <p class="card-text">
                                Max: {result.main.temp_max}
                                {result.units}, Min: {result.main.temp_min}
                                {result.units}
                            </p>
                            <div id="img-container">
                                {result.weather[0].description}<img
                                    src="http://openweathermap.org/img/w/{result
                                        .weather[0].icon}.png"
                                    alt="weather"
                                />
                            </div>
                        </div>
                    </div>
                </div>
            {:else if result.error}
                <div class="alert alert-danger" role="alert">
                    {result.error}
                </div>
            {/if}
        </form>
    </div>
</main>

<style>
    main {
        margin-left: 250px;
    }

    .card.container {
        margin-top: 10px;
        background-color: #c4cfed;
        border-radius: 20px;
        padding: 20px;
    }

    #city {
        width: 50%;
    }
    h5,
    h6,
    p,
    form {
        font-family: "Quicksand", sans-serif;
        font-weight: 500;
        font-size: 1rem;
    }

    h5 {
        font-size: 1.5rem;
    }

    .btn {
        background-color: white;
        color: black;
        font-weight: bolder;
        border: none;
    }

    .btn:hover {
        background-color: rgb(59, 59, 59);
        color: rgb(255, 255, 255);
        font-weight: bolder;
        border: none;
        box-shadow: none;
    }

    .btn:focus {
        background-color: rgb(59, 59, 59);
        color: rgb(255, 255, 255);
        font-weight: bolder;
        border: none;
        box-shadow: none;
    }

    #img-container {
        text-transform: capitalize;
    }
</style>
