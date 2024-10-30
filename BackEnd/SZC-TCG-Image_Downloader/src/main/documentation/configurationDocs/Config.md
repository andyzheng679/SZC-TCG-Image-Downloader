Configuration class, used for defining beans that will be managed by the spring container. 
Manage the creation of RestTemplate & ObjectMapper that are needed in Service Class.

RestTemplate class: used to perform HTTP requests to external API's.

ObjectMapper class: used to map JSON to Java objects and vice versa.

Centralized Configuration. Can set configuration so that everytime those classes are inject, they have the same behavior. Currently, no customizations, just default configurations.