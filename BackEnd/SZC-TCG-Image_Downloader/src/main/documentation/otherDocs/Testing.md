Documentation on Testing (Mockito)

When using @WebMvcTest, use @MockBean to replace beans. @WebMvcTest focuses on the controllers, MockMvc is used for simulating HTTP requests.
It excludes other layers. 

@MockBean creates a mock version of a Spring Bean, it will behave like the original component, but will not actually execute any logic/methods. 
