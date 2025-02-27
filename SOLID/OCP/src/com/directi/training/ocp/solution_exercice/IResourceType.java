package com.directi.training.ocp.solution_exercice;

public interface IResourceType {
    void makeBusy(int resourceId);
    void makeFree(int resourceId);
    int isFree(IResourceType resourceType);
}
