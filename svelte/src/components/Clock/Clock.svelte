<script>
    import { onMount } from "svelte";

    const key="17d1f3c6b2b34e8aa2331f7786a6cd3b"

    let time = new Date();

    // these automatically update when `time`
    // changes, because of the `$:` prefix
    $: hours = time.getHours();
    $: minutes = time.getMinutes();
    $: seconds = time.getSeconds();

    onMount(() => {
        const interval = setInterval(() => {
            time = new Date();
        }, 1000);

        console.log(new Date())
        return () => {
            clearInterval(interval);
        };
    });
</script>


<main>


<h1>{hours}:{minutes}:{seconds}</h1>
</main>

<style>
    
 main{
    margin-left: 245px;
 }
</style>
