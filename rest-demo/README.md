# rest-demo
## Overview
**rest-demo** demostrates several options for implementing queries that offer multiple ways to find resources, each using a mutually exclusive set of parameters.

The solution has 2 primary goals. First, create an API that is intuitive to use and simple to document. The second goal is to use a common URI regardless of the parameter set used.

implements a set of REST operations that generates
- generic greeting (no parameters)
- personalized greeting (takes a name parameter)
- custom greeting (takes greeting phrase and name parameters)

## Implementation Options
These greetings are implemented using three approaches.

**HTTP Get with Query String Parameters (Option 1)** 

In this option, each query string parameter is read and bound to independently defined method parameters.

```java
    @GetMapping(value="/greet", params = {"name"})
    @ResponseBody
    public String greet(@RequestParam String name) {
        return String.format("Hello, %s", name);
    }

    @GetMapping(value="/greet", params = {"greeting", "name"})
    @ResponseBody
    public String greet(@RequestParam String greeting, @RequestParam String name) {
        return String.format("%s, %s", greeting, name);
    }
```