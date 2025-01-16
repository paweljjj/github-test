package paweljjj.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PullRequestState {
    OPEN("Open"),
    MERGED("Merged"),
    CLOSED("Closed");

    public final String label;

}
