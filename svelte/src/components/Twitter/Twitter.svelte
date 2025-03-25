
<script>
    import axios from "axios";
    import { construct_svelte_component, dataset_dev, each } from "svelte/internal";
    import Card from '../Utils/Card.svelte'
    let query = "";
    let resultQuery = "";
    const search = () => {
         axios.get("http://localhost:8081/twittersList/"+query).then((res) => {console.log(res); resultQuery =res});
         query ="";
    }

    const getName = (data) => {
        for(let user of resultQuery.data.includes.users){
            console.log(user)
            console.log(data);
            if(user.id == data.author_id) return user.name;
        }
        return "undefined";
    }
</script>

<main>
    <form on:submit|preventDefault={search}>
        <input type="text" placeholder="Que voulez vous chercher ?" name="search" bind:value={query}/>
        <button type ="submit">Rechercher</button>
    </form>

    {#if resultQuery != ""}
    {#each resultQuery.data.data as data}
    <Card>
        <div slot="header">
            {getName(data)}
        </div>
        <div slot="footer">
            {data.text}
        </div>
    </Card>
    {/each}
    {/if}
</main>

<style>
    main{
       margin-left: 245px;
    }
    form{
        margin-bottom: 50px;
    }
    button{
        margin-left: 10px;
    }
    input{
        width: 80%;
    }
</style>