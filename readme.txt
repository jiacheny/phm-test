Notes for the final math algorithms.

The main logic starts from `calculate()`, and return the final result for the inputs.

Suppose there are a trillion inputs, and so that `List<Double> inputs` takes a majority of the memory.

`List<Double> subset` is the only set, which dynamically holds all the possible subsets during the runtime. The maximum elements the subset might hold is equal to the number of the inputs. Hence, this memory required for this logic will be equal to the double size of the maximum allowance of the inputs.

In order to avoid one string holding a final expressed equations and excess the memory one string can hold, the subset equation will be written into the file once the subset is found. Hence, the number of the read and write into a file is also equal to the number of inputs.