import java.util.List;

public boolean deleteMenuSolo(Long idMenu){
    RC_Menu menu = get(idMenu);

    // Check if the menu has children
    List<RC_Menu> children = menuRepository.getChildren(idMenu);
    if(children != null && !children.isEmpty()) {
        // If there are children, recursively delete each child
        for(RC_Menu child : children) {
            deleteMenuSolo(child.getId());
        }
    }

    // Update properties of the current menu's children
    updateChildrenProperties(menu);

    // Delete the current menu
    delete(idMenu);

    return true;
}

private void updateChildrenProperties(RC_Menu menu) {
    // Get the children of the current menu
    List<RC_Menu> children = menuRepository.getChildren(menu.getId());
    if(children != null && !children.isEmpty()) {
        // If there are children, update their properties recursively
        for(RC_Menu child : children) {
            child.setLevel(child.getLevel() - 1);  // Decrease the level by 1
            child.setParentId(menu.getParentId()); // Set the parent ID to the parent of the deleted menu
            update(child); // Update the child's properties in the database
            // Recursively update properties of the children's children
            updateChildrenProperties(child);
        }
    }
}
