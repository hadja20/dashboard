<script>
    import { onMount } from "svelte";

    const key =
        "live_Or9pkV8WzROXI87LAeJUgrpAJLMP6oX2lVwhT5NqffBwrG4eIPf6tNu7mAxQuUoV";
    let quote = [];

    onMount(async () => {
        await fetch(`https://quotes.rest/qod?language=en`).then(async (res) => {
            const getData = await res.json();

            quote = getData.contents.quotes;
            console.log(quote);
        });
    });
</script>

<main>
    {#if quote != ""}
        <div class="card" style="width: 30rem;">
            <img class="card-img-top" src={quote[0].background} alt="card" />
            <div class="card-body">
                <h5 class="card-title">{quote[0].title}</h5>
                <h6 class="card-subtitle mb-2 text-muted">
                    category: {quote[0].category} | author: {quote[0].author}
                </h6>
                <p class="card-text">{quote[0].quote}</p>

                <a href={quote[0].permalink} class="btn btn-primary">Go somewhere</a>
            </div>
        </div>
    {/if}
</main>

<style>
    main {
        margin-left: 245px;
    }
</style>
