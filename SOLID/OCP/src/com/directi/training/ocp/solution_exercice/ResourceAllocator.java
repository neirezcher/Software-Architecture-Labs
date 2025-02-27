package com.directi.training.ocp.solution_exercice;

public class ResourceAllocator {
    public void allocate(IResourceType resourceType, int resourceId)
    {
        resourceType.makeBusy(resourceId);
    }

    public void free(IResourceType resourceType, int resourceId)
    {
        resourceType.makeFree(resourceId);
    }

    public void findFreeSlot(IResourceType resourceType)
    {
        resourceType.isFree(resourceType);
    }
}
