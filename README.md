# month-number

Turn any English month name into its numeric month instantly — no arrays, no maps, no storage, just math.

---

## Why This Project is Awesome

- **No memory wasted** – No string arrays or lookups; the formula works directly from the first three letters.
- **Compact and clever** – A tiny math formula maps all month names perfectly.
- **Flexible** – Supports full names, abbreviations, and any capitalization.
- **Demonstrates perfect hashing** – Shows how a simple deterministic formula can replace traditional storage-based approaches.

---

## Example Output

```text
Input: January  ->  Month #: 1
Input: JAN      ->  Month #: 1
Input: february ->  Month #: 2
Input: Mar      ->  Month #: 3
Input: AUG      ->  Month #: 8
Input: December ->  Month #: 12