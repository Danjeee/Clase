Loren, he usado en el examen ArrayList en lugar de Set porque considero que al haber 
menos entidades y menos datos, es una opción más rápida, libre de errores y más fácil
de manejar, además, en el examen no se especifica si ha de ser Set o List en las
relaciones, por eso mi elección

Las relaciones N a N las tienen las entidades dentro de ellas pero no están en el
DTO puesto que es algo que no se va a utilizar en ningún momento

He usado .stream().map() en las listas para hacer más rápido y eficiente las 
transformaciones de entidad a DTO