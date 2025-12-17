@Operation(
    summary = "Create a new user",
    description = "Create a user by providing user details",
    responses = {
        @ApiResponse(responseCode = "200", description = "User created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid user data provided")
    }
)
