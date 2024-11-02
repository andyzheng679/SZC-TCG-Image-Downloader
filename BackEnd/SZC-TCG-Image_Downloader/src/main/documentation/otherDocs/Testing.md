Documentation on Testing (Mockito)

When using @WebMvcTest, use @MockBean to replace beans. @WebMvcTest focuses on the controllers, MockMvc is used for simulating HTTP requests.
It excludes other layers. 

@MockBean creates a mock version of a Spring Bean, it will behave like the original component, but will not actually execute any logic/methods. 

@Mock is used to create mock instance of a class/interface.
@InjectMocks injects the mocks created with @Mock into the class.

The main difference between the two (@MockBean and @Mock) is @MockBean is used when working with Spring specific test like @WebMvcTest, and @Mock is used without involving Spring.
@MockBean creates a mock into Spring's environment so Spring can manage it, which replaces reals components with mock versions withing the Spring set up.
@Mock creates simple mocks for testing, but it is not managed by Spring.

Don't need to mock basic Java methods like String.valueOf, or standard library methods since it will always work the same way. We mock to control their outcomes to test scenarios.

when().thenReturn(); This is used for defining the behaviors. when() specifies a method call, .thenReturn() defines what the method call should return. 

use ClassName.class to specify the type of class. Example: Iterator<JsonNode> testArrayData = mock(Iterator.class);
