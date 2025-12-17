import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@GetMapping("/{id}")
public EntityModel<User> getUserById(@PathVariable Long id) {
    User user = userService.findById(id);
    EntityModel<User> resource = EntityModel.of(user);
    resource.add(linkTo(methodOn(UserController.class).getUserById(id)).withSelfRel());
    resource.add(linkTo(methodOn(UserController.class).getUsers()).withRel("users"));
    return resource;
}
