# Principais comandos

## Como iniciar um container (que ainda não existe)?

```
    docker run NOME-DA IMAGEM

    EX: docker run docker/getting-started
```

## para listar os container que estão em execução

```
    docker ps
```

# Se eu quiser parar a execuçõ de um container:

```
    docker stop NOMEDOCONTAINER
    Ex: docker stop elated_poitras
```

# Se eu quiser iniciar um container que já existe:

```
    docker start NOMEDOCONTAINER
    Ex: docker start elated_poitras
```

# Para remover um container:

Obs: o container deve estar parado!!!!!

```
    docker rm NOMEDOCONTAINER
    Ex: docker rm elated_poitras
```

