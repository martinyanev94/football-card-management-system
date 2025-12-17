@Test
public void testDeleteUser() throws Exception {
    doNothing().when(userService).deleteUser(1L);

    mockMvc.perform(delete("/users/1"))
            .andExpect(status().isNoContent());

    verify(userService).deleteUser(1L);
}

@Test
public void testDeleteUserNotFound() throws Exception {
    doThrow(new EntityNotFoundException()).when(userService).deleteUser(1L);

    mockMvc.perform(delete("/users/1"))
            .andExpect(status().isNotFound());
}
