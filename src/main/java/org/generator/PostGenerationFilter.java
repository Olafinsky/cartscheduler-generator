package org.generator;

public interface PostGenerationFilter {
    boolean isAccepted(Sheet sheet, SubSheet subSheet);
}